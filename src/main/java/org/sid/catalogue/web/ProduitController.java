package org.sid.catalogue.web;

import java.util.Optional;
import javax.validation.Valid;
import org.sid.catalogue.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sid.catalogue.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository ;
    
    @RequestMapping(value="/index")
    public String index(Model model, 
            @RequestParam(name = "page", defaultValue = "0")int p, 
            @RequestParam(name = "size", defaultValue = "4")int s,  
            @RequestParam(name = "motCle", defaultValue = "")String mc){
        Page<Produit> pageProduits = produitRepository.chercher("%"+mc+"%",PageRequest.of(p,s));
        model.addAttribute("listProduit", pageProduits.getContent());
        int pages[] = new int[pageProduits.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante", p);
         model.addAttribute("motCle", mc);
        return "produits";
    }
    
    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String delete(Long id,String motCle, int page,int size){
        produitRepository.deleteById(id);
        return "redirect:/index?page="+page+"&size="+size+"&motCle="+motCle;
    }
    
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String delete(Model model){
       model.addAttribute("produit", new Produit());
        return "FormProduit";
    }
    
    @RequestMapping(value="/edit", method = RequestMethod.GET)
    public String edit(Model model,Long id){
         Optional <Produit> p =  produitRepository.findById(id);
       model.addAttribute("produit", p.get());
        return "editProduit";
    }
    
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Model model, @Valid Produit produit, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "FormProduit";
       produitRepository.save(produit);
        return "Confirmation";
    }
}
