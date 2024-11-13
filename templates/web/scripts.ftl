<#-- scripts.ftl -->
<!-- jQuery -->
<script src="/static/js/jquery-2.1.0.min.js"></script>

<!-- Bootstrap -->
<script src="/static/js/popper.js"></script>
<script src="/static/js/bootstrap.min.js"></script>

<!-- Plugins -->
<script src="/static/js/owl-carousel.js"></script>
<script src="/static/js/accordions.js"></script>
<script src="/static/js/datepicker.js"></script>
<script src="/static/js/scrollreveal.min.js"></script>
<script src="/static/js/waypoints.min.js"></script>
<script src="/static/js/jquery.counterup.min.js"></script>
<script src="/static/js/imgfix.min.js"></script> 
<script src="/static/js/slick.js"></script> 
<script src="/static/js/lightbox.js"></script> 
<script src="/static/js/isotope.js"></script> 

<!-- Global Init -->
<script src="/static/js/custom.js"></script>

<script>
    $(function() {
        var selectedClass = "";
        $("p").click(function(){
            selectedClass = $(this).attr("data-rel");
            $("#portfolio").fadeTo(50, 0.1);
            $("#portfolio div").not("." + selectedClass).fadeOut();
            setTimeout(function() {
                $("." + selectedClass).fadeIn();
                $("#portfolio").fadeTo(50, 1);
            }, 500);
        });
    });
</script>
