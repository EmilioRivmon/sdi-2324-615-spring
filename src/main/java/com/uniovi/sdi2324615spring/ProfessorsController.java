package com.uniovi.sdi2324615spring;
import com.uniovi.sdi2324615spring.Professor;
import com.uniovi.sdi2324615spring.ProfessorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professor")
public class ProfessorsController {

    @Autowired
    private ProfessorsService professorsService;

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("professors", professorsService.getAllProfessors());
        return "professor/list";
    }

    @GetMapping("/add")
    public String getAddForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/add";
    }

    @PostMapping("/add")
    public String addProfessor(@ModelAttribute Professor professor) {
        professorsService.addProfessor(professor);
        return "redirect:/professor/list";
    }

    @GetMapping("/delete/{dni}")
    public String deleteProfessor(@PathVariable String dni) {
        professorsService.deleteProfessor(dni);
        return "redirect:/professor/list";
    }
}

