<div class="carousel slide" id="header-carousel" data-ride="carousel">
    <div class="carousel-inner">
        <#-- Dynamically render slides -->
        <#list carouselItems as item>
            <div class="carousel-item ${item.active?string('active', '')}">
                <img src="${item.image}" alt="Slide">
                <div class="carousel-caption">
                    <h1>${item.title}</h1>
                    <p>${item.description}</p>
                </div>
            </div>
        </#list>
    </div>
</div>
