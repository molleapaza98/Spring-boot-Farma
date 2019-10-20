package com.farma.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.farma.entities.Medicine;
import com.farma.entities.Patient;
import com.farma.entities.Voucher;
import com.farma.entities.VoucherDetail;
import com.farma.service.MedicineService;
import com.farma.service.PatientService;
import com.farma.service.VoucherService;

@Controller
@SessionAttributes("voucher")
@RequestMapping("/vouchers")
public class VoucherController {

	@Autowired
	private VoucherService voucherService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private MedicineService medicineService;

	@GetMapping("/form/{patientId}")
	public String formVoucher(@PathVariable(value = "patientId") Long patientId, Model model) {
		try {
			Optional<Patient> patient = patientService.findById(patientId);
			if (!patient.isPresent()) {
				model.addAttribute("info", "Paciente no existe");
				return "redirect:/patient/list";
			} else {
				Voucher voucher = new Voucher();
				voucher.setPatientId(patient.get());
				model.addAttribute("voucher", voucher);
			}

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());

		}
		return "voucher/form";
	}

	@PostMapping("/save")
	public String saveVoucher(Voucher voucher, Model model,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "quantity[]", required = false) Integer[] quantity, SessionStatus status) {
		try {

			if (itemId == null || itemId.length == 0) {
				model.addAttribute("info", "Voucher no tiene medicamento");
				return "voucher/form";

			} else {
				for (int i = 0; i < itemId.length; i++) {
					Optional<Medicine> medicine = medicineService.findById(itemId[i]);
					if (medicine.isPresent()) {
						VoucherDetail line = new VoucherDetail();
						line.setQuantity(quantity[i]);
						line.setMedicineId(medicine.get());
						voucher.addVoucherDetail(line);
					}
				}
				voucherService.save(voucher);
				status.setComplete();
				model.addAttribute("success", "Voucher Generado");
			}

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());

		}
		return "redirect:/patients/detail/" + voucher.getPatientId().getId();
	}
	
	@GetMapping("/detail/{id}")
	public String detailVoucher(@PathVariable(value = "id") Long id, Model model) {

		try {
			Optional<Voucher> voucher = voucherService.fetchByVoucherIdWithPatientWithVoucherDetailWithMedicine(id);
			if (!voucher.isPresent()) {
				model.addAttribute("error", "Voucher no existe");
				return "redirect:/patients/list";
			}

			model.addAttribute("voucher", voucher.get());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "voucher/detail";
	}

}