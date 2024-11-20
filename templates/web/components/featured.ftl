<section class="featured-products">
    <div class="container">
        <h2>Featured Products</h2>
        <div class="row">
            <#list featuredProducts as product>
                <div class="col-md-3">
                    <div class="product">
                        <img src="${product.image}" alt="${product.name}">
                        <h3>${product.name}</h3>
                        <p>${product.price}</p>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</section>
