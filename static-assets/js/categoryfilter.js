document.addEventListener("DOMContentLoaded", function () {
document.querySelector("#macroCategory_o"); // for an element with id="macrocategoryId"
document.querySelector("#category_o"); // for an element with id="categoryId"

    macrocategorySelector.addEventListener("change", async function () {
        const selectedMacrocategory = macrocategorySelector.value;
        const categories = await fetchCategoriesByMacrocategory(selectedMacrocategory);
        updateCategoryOptions(categorySelector, categories);
    });
});

async function fetchCategoriesByMacrocategory(macrocategoryId) {
    // Replace 'YOUR_SITE' with your actual CrafterCMS site name
    const response = await fetch(`/api/1/site/content_store/children.json?url=/site/components/categories&crafterSite=hubmanagment`);
    const data = await response.json();
    
    // Filter categories by macrocategory ID
    return data.children.filter(item => item.macrocategory_o === macrocategoryId);
}

function updateCategoryOptions(categorySelector, categories) {
    // Clear previous options
    categorySelector.innerHTML = "";

    // Populate new options based on selected Macro Category
    categories.forEach(category => {
        const option = document.createElement("option");
        option.value = category.name;
        option.textContent = category.label || category.categoryname_s;
        categorySelector.appendChild(option);
    });
}