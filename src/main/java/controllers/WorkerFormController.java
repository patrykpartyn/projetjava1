package controllers;

import models.Worker;
import models.WorkerType;
import models.WorkerWorkArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import repositories.WorkerRepository;
import repositories.WorkerTypeRepository;
import repositories.WorkerWorkAreaRepository;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@SessionAttributes
public class WorkerFormController {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkerTypeRepository workerTypeRepository;

    @Autowired
    private WorkerWorkAreaRepository workerWorkAreaRepository;

    @RequestMapping(value="/workerForm.html",method = RequestMethod.GET)
    public String showForm(Model model, @RequestParam(name="id", required = false, defaultValue = "-1") long id){
        Worker w;
        if(id>0){
            w=workerRepository.findById(id).get();
        }else
        {
            w=new Worker();

        }
        model.addAttribute("worker",w);
        return "workerForm";
    }

    @RequestMapping(value="/workerForm.html",method = RequestMethod.POST)
    public String processForm(@ModelAttribute("worker")@Valid Worker w, BindingResult result){
        if(result.hasErrors()){
            return "workerForm";
        }

        workerRepository.save(w);

        return "successVehicleForm";

    }

    @ModelAttribute("workerType")
    public List<WorkerType> loadTypes(){
        List<WorkerType> types = workerTypeRepository.findAll();
//        log.info("Ładowanie listy "+types.size()+" typów ");
        return types;
    }

    @ModelAttribute("workerWorkArea")
    public List<WorkerWorkArea> loadTypesArea(){
        List<WorkerWorkArea> types = workerWorkAreaRepository.findAll();
//        log.info("Ładowanie listy "+types.size()+" typów ");
        return types;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {//Rejestrujemy edytory właściwości

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "employmentDate", new CustomDateEditor(dateFormat, false));

        DecimalFormat numberFormat = new DecimalFormat("#0.00");
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
        binder.registerCustomEditor(Float.class, "salary", new CustomNumberEditor(Float.class, numberFormat, false));

    }


}
