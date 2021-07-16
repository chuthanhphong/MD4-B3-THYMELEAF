package Controller;


import ModelProduct.Product;
import Service.IProductService;
import Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findALL();
        model.addAttribute("product", productList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product){
        product.setId((int) Math.random()*1000);
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.edit(product.getId(),product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
        productService.delete(product.getId());
        redirectAttributes.addFlashAttribute("success","delete product successfully");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }
    @PostMapping("/search")
    public String search(@RequestParam String name, Model model){

       model.addAttribute("product",productService.search(name));
       return "/index";
    }


}
