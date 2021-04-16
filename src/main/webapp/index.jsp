<%@page import="com.sanvalero.alive.domain.Cancion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sanvalero.alive.dao.CancionDAO"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">

    <title>ALive</title>


    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="css/font-awesome.css">

    <link rel="stylesheet" href="css/templatemo-softy-pinko.css">

    </head>
    
    <body>
    
    <!-- ***** Preloader Start ***** -->
    <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>  
    <!-- ***** Preloader End ***** -->
    
    
    <!-- ***** MENU / HEADER START ***** -->
    <header class="header-area header-sticky">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav">
                        <!-- ***** Logo Start ***** -->
                        <a href="#" class="logo">
                            <img src="images/logo.png" alt="Softy Pinko"/>
                        </a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li><a href="#welcome" class="active">HOME</a></li>
                            <li><a href="#usuarios">USERS</a></li>
                            <li><a href="#canciones">SONGS</a></li>
                            <li><a href="#form">ADD</a></li>
                        </ul>
                        <a class='menu-trigger'>
                            <span>Menu</span>
                        </a>
                        <!-- ***** Menu End ***** -->
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** MENU / HEADER END ***** -->

    <!-- ***** INFO START ***** -->
    <div class="welcome-area" id="welcome">

        <!-- ***** HEADER TEXT START ***** -->
        <div class="header-text">
            <div class="container">
                <div class="row">
                    <div class="offset-xl-3 col-xl-6 offset-lg-2 col-lg-8 col-md-12 col-sm-12">
                        <h1>Got a song stuck in your head? <br>Share your <strong>suffering</strong> and tell us all about it!</h1>
                    </div>
                </div>
            </div>
        </div>
        <!-- ***** HEADER TEXT END ***** -->
    </div>
    <!-- ***** INFO END***** -->

    <!-- ***** FUNCIONES START ***** -->
    <section class="section home-feature">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-4 col-md-6 col-sm-6 col-12" data-scroll-reveal="enter bottom move 50px over 0.6s after 0.2s">
                            <div class="features-small-item">
                                <div class="icon">
                                    <i><img src="images/featured-item-01.png" alt=""></i>
                                </div>
                                <h5 class="features-title">Discover</h5>
                                <p>Discover new music everyday with our endless playlists! Just check out down below.</p>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 col-sm-6 col-12" data-scroll-reveal="enter bottom move 50px over 0.6s after 0.4s">
                            <div class="features-small-item">
                                <div class="icon">
                                    <i><img src="images/featured-item-01.png" alt=""></i>
                                </div>
                                <h5 class="features-title">Add</h5>
                                <p>You can add any new song that you find. From punk to funk, you can share it with others!</p>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 col-sm-6 col-12" data-scroll-reveal="enter bottom move 50px over 0.6s after 0.6s">
                            <div class="features-small-item">
                                <div class="icon">
                                    <i><img src="images/featured-item-01.png" alt=""></i>
                                </div>
                                <h5 class="features-title">MeetUp</h5>
                                <p>Connect with others around the world and share your interest in music. What are you waiting for?</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ***** FUNCIONES END ***** -->

    <!-- ***** Features Big Item Start ***** -->
    <section class="section padding-top-70 padding-bottom-0" id="usuarios">
        <div class="container">
            <div class="row">
                <div class="col-lg-5 col-md-12 col-sm-12 align-self-center" data-scroll-reveal="enter left move 30px over 0.6s after 0.4s">
                    <img src="images/left-image.png" class="rounded img-fluid d-block mx-auto" alt="App">
                </div>
                <div class="col-lg-1"></div>
                <div class="col-lg-6 col-md-12 col-sm-12 align-self-center mobile-top-fix">
                    <div class="left-heading">
                        <h2 class="section-title">Don't know what to listen to?
                        </h2>
                    </div>
                    <div class="left-text">
                     <h6>Hit it!</h6>
                        <p>Check out our entire music catalouge and listen to whatever floats your boat. If you don't like a certain song, hey, we get it. Just delete it from the playlist and you're good to go. </p>
                        <%
                                CancionDAO cancionDAO = new CancionDAO();
                                ArrayList<Cancion> canciones = cancionDAO.getAllCanciones();
                            %>
                            <ul>
                            <%
                                for (Cancion cancion : canciones) {
                            %>
                            <li><%= cancion.getNombre() %> <a href="remove-cancion?id=<%= cancion.getIdcancion() %>"> Scrap it!</a></li>
                            <%    
                                }
                            %>
                            </ul>
                            
                            <%
                                // Muestra el mensaje (si lo hay)
                                String message = request.getParameter("message");
                                if (message != null) {
                            %>
                                <p style='color:green'><%= message %></p>
                            <%        
                                }
                        %>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="hr"></div>
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Features Big Item End ***** -->

    <!-- ***** Features Big Item Start ***** -->
    <section class="section padding-bottom-100">
        <div class="container" id="canciones">
            <div class="row" >
                <div class="col-lg-6 col-md-12 col-sm-12 align-self-center mobile-bottom-fix" >
                    <div class="left-heading">
                        <h2 class="section-title">We can help you to grow your business</h2>
                    </div>
                    <div class="left-text">
                        <p>Aenean pretium, ipsum et porttitor auctor, metus ipsum iaculis nisi, a bibendum lectus libero vitae urna. Sed id leo eu dolor luctus congue sed eget ipsum. Nunc nec luctus libero. Etiam quis dolor elit.</p>
                    </div>
                </div>
                <div class="col-lg-1"></div>
                <div class="col-lg-5 col-md-12 col-sm-12 align-self-center mobile-bottom-fix-big" data-scroll-reveal="enter right move 30px over 0.6s after 0.4s">
                    <img src="images/right-image.png" class="rounded img-fluid d-block mx-auto" alt="App">
                </div>
            </div>
        </div>
    </section>
    <!-- ***** Features Big Item End ***** -->

    <!-- ***** Contact Us Start ***** -->
        <section class="section colored" id="form">
            <div class="container">
                <!-- ***** Section Title Start ***** -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="center-heading">
                            <h2 class="section-title">Help Us Help You</h2>
                        </div>
                    </div>
                    <div class="offset-lg-3 col-lg-6">
                        <div class="center-text">
                            <p>Don't you just hate when you can't add your favourite songs to a playlist? Well, you're in luck! Our members can add any song, anytime, anywhere, any whatever. </p>
                        </div>
                    </div>
                </div>
                <!-- ***** Section Title End ***** -->

                <div class="row">
                    <!-- ***** Contact Text Start ***** -->
                    <div class="col-lg-4 col-md-6 col-sm-12">
                        <h5 class="margin-bottom-30">Add it!</h5>
                        <div class="contact-text">
                            <p>You can add any song you want, at any time! 
                            <br>Seriously.</p>
                            <p>Just give us the songs details, and we'll add it to our database ;) </p>
                        </div>
                    </div>
                    <!-- ***** Contact Text End ***** -->

                    <!-- ***** Contact Form Start ***** -->
                    <div class="col-lg-8 col-md-6 col-sm-12">
                        <div class="contact-form">
                            <form id="contact" action="add-cancion" method="post">
                              <div class="row">
                                <div class="col-lg-6 col-md-12 col-sm-12">
                                  <fieldset>
                                    <input name="name" type="text" id="name" placeholder="What song is it?">
                                  </fieldset>
                                </div>
                                <div class="col-lg-6 col-md-12 col-sm-12">
                                  <fieldset>
                                    <input name="duracion" type="text" id="duracion" placeholder="How long is it?" >
                                  </fieldset>
                                </div>
                                <br>
                                 <div class="col-lg-6 col-md-12 col-sm-12">
                                  <fieldset>
                                    <input name="id" type="text" id="name" placeholder="What's the song's ID?" >
                                  </fieldset>
                                </div>
                                <div class="col-lg-6 col-md-12 col-sm-12">
                                  <fieldset>
                                    <input name="favorita" type="text" id="favorita" placeholder="Is it your favorite?">
                                  </fieldset>
                                </div>
                                
                                <div class="col-lg-12">
                                  <fieldset>
                                    <button type="submit" id="form-submit" class="main-button">Let's go!</button>
                                  </fieldset>
                                </div>
                              </div>
                            </form>
                         <%
                            String status = request.getParameter("status");
                            if (status == null)
                                status = "";

                            if (status.equals("ok")) {
                                out.println("<p style='color:green'>La canción se ha registrado con éxito</p>");
                            } else if (status.equals("error")) {
                                out.println("<p style='color:red'>No se ha podido registrar la canción</p>");
                            }
                        %>
                        </div>
                    </div>
                    <!-- ***** Contact Form End ***** -->
                </div>
            </div>
        </section>
        <!-- ***** Contact Us End ***** -->


    
    
    <!-- ***** Footer Start ***** -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <ul class="social">
                        <li><a href="https://es-es.facebook.com/sanvalero/"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="https://twitter.com/centrosanvalero/"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="https://es.linkedin.com/company/san-valero"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <p class="copyright">Copyright &copy; 2020 Softy Pinko Company - Design: TemplateMo</p>
                </div>
            </div>
        </div>
    </footer>
    
    <!-- jQuery -->
    <script src="js/jquery-2.1.0.min.js"></script>

    <!-- Bootstrap -->
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugins -->
    <script src="js/scrollreveal.min.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imgfix.min.js"></script> 
    
    <!-- Global Init -->
    <script src="js/custom.js"></script>

  </body>
</html>