<section class="section" id="explore">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="left-content">
                    <h2>${explore.title}</h2>
                    <p>${explore.description}</p>
                    <a href="${explore.link}" class="main-border-button">Discover More</a>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="right-content">
                    <div class="row">
                        <#list explore.images as image>
                            <div class="col-lg-6">
                                <div class="${image.class}">
                                    <img src="${image.src}" alt="${image.alt}">
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
