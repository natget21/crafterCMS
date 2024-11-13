document.addEventListener("DOMContentLoaded", function () {
    const macrocategorySelector = document.querySelector("[name='macrocategories']");
    const categorySelector = document.querySelector("[name='categories']");

    macrocategorySelector.addEventListener("change", async function () {
        const selectedMacrocategory = macrocategorySelector.value;
        const categories = await fetchCategoriesByMacrocategory(selectedMacrocategory);
        updateCategoryOptions(categorySelector, categories);
    });
});

async function fetchCategoriesByMacrocategory(macrocategoryId) {
    // Replace 'YOUR_SITE' with your actual CrafterCMS site name
    const response = await fetch(`/api/1/site/content_store/children.json?url=/site/categories&crafterSite=hubmanagment`);
    const data = await response.json();
    
    // Filter categories by macrocategory ID
    return data.children.filter(item => item.macrocategory === macrocategoryId);
}

function updateCategoryOptions(categorySelector, categories) {
    // Clear previous options
    categorySelector.innerHTML = "";

    // Populate new options based on selected Macro Category
    categories.forEach(category => {
        const option = document.createElement("option");
        option.value = category.name;
        option.textContent = category.label || category.name;
        categorySelector.appendChild(option);
    });
}