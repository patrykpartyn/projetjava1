package controllers;

import models.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repositories.VehicleRepository;


@Controller
public class VehiclesListController{

	private VehicleRepository vehicleRepository;

	public VehiclesListController(VehicleRepository repository){
		this.vehicleRepository = repository;
	}

	@RequestMapping(value="/vehicleList.html", params = "id", method = RequestMethod.GET)
	public String showVehicleDetails(Model model, long id){
		System.out.println("Pokayzwanie szczegółów");

		Vehicle v = vehicleRepository.findById(id).get();
		//obłużyć not found exception
		model.addAttribute("vehicle", v);
		return "vehicleDetails";
	}

	@RequestMapping(value="/vehicleList.html", method = RequestMethod.GET)
	public String showVehicleList(Model model){
		model.addAttribute("vehicleList", vehicleRepository.findAll());
		return "vehicleList";
	}

	@GetMapping(path="/vehicleList.html", params={"did"})
	public String deleteVehicle(long did){
		vehicleRepository.deleteById(did);
		return "redirect:vehicleList.html";
	}

}
