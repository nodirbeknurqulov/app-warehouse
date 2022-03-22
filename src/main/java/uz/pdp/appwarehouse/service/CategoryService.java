package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.CategoryDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CategoryRepository;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

// Nurkulov Nodirbek 3/8/2022  12:21 PM

@Service
public class CategoryService {

    //    {
//        "name":"Telephones",
//            "parentCategoryId":1
//    }
    @Autowired
    CategoryRepository categoryRepository;


    /**
     * GET ALL CATEGORIES
     *
     * @return List
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    /**
     * GET CATEGORY BY ID
     *
     * @param id Integer
     * @return Result
     */
    public Result getCategoryById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setParentCategory(category.getParentCategory());
            category.setActive(category.isActive());
            category.setName(category.getName());
            categoryRepository.save(category);
            return new Result(category, true);
        }
        return new Result("Category not found", false);
    }



    /**
     * ADD CATEGORY
     * @param categoryDto Category
     * @return Result
     */
    public Result addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalParentCategory.isPresent())
                return new Result("Father category does not exist", false);
            category.setParentCategory(optionalParentCategory.get());
        }
        categoryRepository.save(category);
        return new Result("Category added!!!", true);
    }



    /**
     * UPDATE CATEGORY
     * @param id Integer
     * @param categoryDto Category
     * @return Result
     */
    public Result updateCategory(Integer id, CategoryDto categoryDto){
//        Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
//        if (optionalCategory.isPresent()){
//            return new Result("Category updated!!!",true);
//        }

        //checking category name
        boolean existsByName = categoryRepository.existsByName(categoryDto.getName());
        if (existsByName){
            Category category = new Category();
            category.setName(categoryDto.getName());



        }
        return null;

    }








    // TODO: 3/21/2022
    //  get all categories,
    //  get category by id,
    //  update category,
    //  delete category
}
