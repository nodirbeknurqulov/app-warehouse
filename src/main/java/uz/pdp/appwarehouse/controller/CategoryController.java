package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.payload.CategoryDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.CategoryService;

import java.util.List;

// Nurkulov Nodirbek 3/8/2022  2:31 PM
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * GET ALL CATEGORIES
     * @return List
     */
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    /**
     * GET CATEGORY BY ID
     * @param id Integer
     * @return Result
     */
    @GetMapping("/{id}")
    public Result getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    /**
     * ADD CATEGORY
     * @param categoryDto Category
     * @return Result
     */
    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    /**
     * UPDATE CATEGORY BY ID
     * @param categoryDto CategoryDto
     * @param id Integer
     * @return Result
     */
    @PutMapping("/{id}")
    public Result updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer id){
        return categoryService.updateCategory(id, categoryDto);
    }

    /**
     * DELETE CATEGORY BY ID
     * @param id Integer
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }
}
