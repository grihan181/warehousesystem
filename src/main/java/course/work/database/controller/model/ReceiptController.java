package course.work.database.controller.model;

import course.work.database.model.Receipt;
import course.work.database.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receipt")  //TODO фронт
public class ReceiptController {

    @Autowired
    private ReceiptService service;


    @GetMapping("getAll")
    public String getAllReceipt(Model model) {
        model.addAttribute("receipts", service.getAll());
        return "showAllEmployees";
    }
    @GetMapping("addNewReceipt")
    public String addReceipt(Model model) {
        Receipt receipt = new Receipt();
        model.addAttribute("receipt", receipt);
        return "newEmployee";
    }

    @PostMapping("save")
    public String saveReceipt(@ModelAttribute("receipt") Receipt receipt) {
        service.save(receipt);
        return "redirect:/boss/getAllEmployees";
    }

    @GetMapping("showReceiptByIdForUpdate/{id}")
    public String showReceiptByIdForUpdate(@PathVariable long id, Model model) {
        Receipt receipt = service.getByID(id);
        model.addAttribute("receipt", receipt);
        return "update";
    }

    @DeleteMapping("deleteReceiptById/{id}")
    public String deleteReceiptById(@PathVariable long id) {
        service.deleteViaId(id);
        return "redirect:/boss/getAllEmployees";
    }
}
