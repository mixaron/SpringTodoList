package ru.mixaron.springtodolist.controllers;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mixaron.springtodolist.models.TDList;
import ru.mixaron.springtodolist.services.TDListService;
import ru.mixaron.springtodolist.util.TDLValidator;

@Controller
@RequestMapping("/list")
public class ToDoController {

    private final TDListService tdList;

    private final TDLValidator tdlValidator;



    private final TDListService tdListService;


    public ToDoController(TDListService tdList, TDLValidator tdlValidator, TDListService tdListService) {
        this.tdList = tdList;
        this.tdlValidator = tdlValidator;
        this.tdListService = tdListService;
    }

    @GetMapping()
    public String showList( Model model) {
        model.addAttribute("tdlist", tdListService.tdLists());
        return "list";
    }

    @GetMapping("/changeList/{id}")
    public String showListChange(@PathVariable("id") int id, Model model) {
        model.addAttribute("tdlist", tdListService.findOne(id));
        return "changeList";
    }

    @PostMapping("/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("tdlist") @Valid TDList tdList1, BindingResult bindingResult) {
        tdlValidator.validate(tdList1, bindingResult);
        if (bindingResult.hasErrors()) {
            return "changeList";
        }
        tdListService.edit(id, tdList1);
        return "redirect:/list";
    }



    @GetMapping("/addList")
    public String addList(@ModelAttribute("tdlist") TDList tdList) {
        return "AddRow";
    }

    @PostMapping("/add")
    public String addListPost(@ModelAttribute("tdlist") @Valid TDList tdList, BindingResult bindingResult) {
        tdlValidator.validate(tdList, bindingResult);
        if (bindingResult.hasErrors()) {
            return "AddRow";
        }
        tdListService.save(tdList);
        return "redirect:/list";
    }


}
