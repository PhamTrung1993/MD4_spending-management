package com.codegym.controller;

import com.codegym.model.Expenditures;
import com.codegym.model.ExpendituresForm;
import com.codegym.service.expenditures.IExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ExController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IExService exService;

    @GetMapping("list")
    public ModelAndView show() {
        List<Expenditures> expenditures = exService.findAll();
        return new ModelAndView("/list","list",expenditures);

    }
    @GetMapping("create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("exForm", new ExpendituresForm());
        return modelAndView;
    }
    @PostMapping("save")
    public ModelAndView saveProduct(@ModelAttribute ExpendituresForm expendituresForm) {
        MultipartFile multipartFile = expendituresForm.getInvoicePhoto();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(expendituresForm.getInvoicePhoto().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Expenditures expenditures = new Expenditures(expendituresForm.getId(), expendituresForm.getExName(),
                expendituresForm.getExPrice(),expendituresForm.getExDescription(),expendituresForm.getExCategory(), fileName);
        exService.save(expenditures);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("exForm", expendituresForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Expenditures expenditures = exService.findById(id);
        if (expenditures != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("ex", expenditures);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("editSave")
    public ModelAndView editSaveProduct(@ModelAttribute ExpendituresForm expendituresForm) {
        MultipartFile multipartFile = expendituresForm.getInvoicePhoto();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(expendituresForm.getInvoicePhoto().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Expenditures expenditures = new Expenditures(expendituresForm.getId(), expendituresForm.getExName(),
                expendituresForm.getExPrice(),expendituresForm.getExDescription(),expendituresForm.getExCategory(), fileName);
        exService.save(expenditures);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("ex", expendituresForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Expenditures expenditures = exService.findById(id);
        if (expenditures != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("ex", expenditures);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute("ex") Expenditures expenditures) {
        exService.remove(expenditures.getId());
        return "redirect:list";
    }
}
