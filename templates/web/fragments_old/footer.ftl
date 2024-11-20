<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="footer-logo">
                    <img src="${footer.logo}" alt="Footer Logo">
                    <ul>
                        <li><a href="#">${footer.address}</a></li>
                        <li><a href="mailto:${footer.email}">${footer.email}</a></li>
                        <li><a href="tel:${footer.phone}">${footer.phone}</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3">
                <h4>${footer.linksTitle}</h4>
                <ul>
                    <#list footer.links as link>
                        <li><a href="${link.href}">${link.title}</a></li>
                    </#list>
                </ul>
            </div>
            <div class="col-lg-3">
                <h4>${footer.infoTitle}</h4>
                <ul>
                    <#list footer.info as info>
                        <li><a href="${info.href}">${info.title}</a></li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</footer>
