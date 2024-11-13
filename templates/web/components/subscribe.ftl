<div class="subscribe">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="section-heading">
                    <h2>${subscribe.heading}</h2>
                    <p>${subscribe.subtitle}</p>
                </div>
                <form id="subscribe" action="${subscribe.action}" method="post">
                    <div class="row">
                        <div class="col-lg-5">
                            <input type="text" name="name" placeholder="Your Name" required>
                        </div>
                        <div class="col-lg-5">
                            <input type="email" name="email" placeholder="Your Email Address" required>
                        </div>
                        <div class="col-lg-2">
                            <button type="submit" class="main-dark-button"><i class="fa fa-paper-plane"></i></button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-4">
                <div class="contact-info">
                    <ul>
                        <li><strong>Store Location:</strong> ${subscribe.location}</li>
                        <li><strong>Phone:</strong> ${subscribe.phone}</li>
                        <li><strong>Email:</strong> ${subscribe.email}</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
