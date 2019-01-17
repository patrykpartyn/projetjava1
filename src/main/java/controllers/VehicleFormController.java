package controllers;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import models.*;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import repositories.*;

import javax.validation.Valid;

@Controller
@SessionAttributes(names={"vehicleTypes", "vehicle"})
public class VehicleFormController {

	protected final Log log = LogFactory.getLog(getClass());//Dodatkowy komponent do logowania

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	@Autowired
	private VehicleTypeDoorsRepository vehicleTypeDoorsRepository;

	@Autowired
	private VehicleColorRepository vehicleColorRepository;

	@Autowired
	private VehicleAreaRentalRepository vehicleAreaRentalRepository;

	@Autowired
	private VehicleTypeEngineRepository vehicleTypeEngineRepository;

	@RequestMapping(value="/vehicleForm.html", method=RequestMethod.GET)
	public String showForm(Model model, @RequestParam(name="id", required = false, defaultValue = "-1") long id){
		Vehicle v;

		if(id>0){
			v = vehicleRepository.findById(id).get();
			//obsłużyć not found exception
		}else{
			v = new Vehicle();
		}
		
		model.addAttribute("vehicle", v);
		return "vehicleForm";
	}



	@ModelAttribute("vehicleTypes")
	public List<VehicleType> loadTypes(){
		List<VehicleType> types = vehicleTypeRepository.findAll();
		log.info("Ładowanie listy "+types.size()+" typów ");
		return types;
	}

	@ModelAttribute("vehicleTypesDoors")
	public List<VehicleTypeDoors> loadTypesDoors(){
		List<VehicleTypeDoors> types = vehicleTypeDoorsRepository.findAll();
		log.info("Ładowanie listy "+types.size()+" typów ");
		return types;
	}

	@ModelAttribute("vehicleColors")
	public List<VehicleColor> loadTypesColors(){
		List<VehicleColor> types = vehicleColorRepository.findAll();
		log.info("Ładowanie listy "+types.size()+" typów ");
		return types;
	}

	@ModelAttribute("vehicleAreas")
	public List<VehicleAreaRental> loadTypesAreas(){
		List<VehicleAreaRental> types = vehicleAreaRentalRepository.findAll();
		log.info("Ładowanie listy "+types.size()+" typów ");
		return types;
	}

	@ModelAttribute("vehicleEngine")
	public List<VehicleTypeEngine> loadTypesEngine(){
		List<VehicleTypeEngine> types = vehicleTypeEngineRepository.findAll();
		log.info("Ładowanie listy "+types.size()+" typów ");
		return types;
	}

	@RequestMapping(value="/vehicleForm.html", method=RequestMethod.POST)
	public String processForm(@ModelAttribute("vehicle") @Valid Vehicle v, BindingResult result){
		if(result.hasErrors()){
			return "vehicleForm";
		}

		log.info("Data utworzenia komponentu "+v.getCreatedDate());
		log.info("Data edycji komponentu "+new Date());

		vehicleRepository.save(v);


		//return "redirect:vehicleList.html";//po udanym dodaniu/edycji przekierowujemy na listę
		return "successVehicleForm";
	}	

    @InitBinder
    public void initBinder(WebDataBinder binder) {//Rejestrujemy edytory właściwości
    	
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "productionDate", new CustomDateEditor(dateFormat, false));

		DecimalFormat numberFormat = new DecimalFormat("#0.00");
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setGroupingUsed(false);
        binder.registerCustomEditor(Float.class, "price", new CustomNumberEditor(Float.class, numberFormat, false));

    }
}








