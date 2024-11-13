<section class="section" id="social">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-heading">
                    <h2>${social.title}</h2>
                    <p>${social.subtitle}</p>
                </div>
            </div>
        </div>
        <div class="row images">
            <#list social.media as media>
                <div class="col-2">
                    <div class="thumb">
                        <a href="${media.link}" target="_blank">
                            <img src="${media.image}" alt="${media.alt}">
                            <h6>${media.label}</h6>
                        </a>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</section>
