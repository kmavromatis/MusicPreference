<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Music Preference</title>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="google-signin-client_id" content="800404509455-bshfcjmmg8ho82qkpaetmv21ummlvi50.apps.googleusercontent.com"/>
        <link href="styles/css.css" rel="stylesheet" type="text/css" />
        <link rel="icon" href="http://www.edmsauce.com/wp-content/uploads/2014/06/sax.png"/>
        <!--[if lt IE 7]>
        <script type="text/javascript" src="js/ie_png.js"></script>
        <script type="text/javascript">ie_png.fix('.png');</script>
        <![endif]-->
    </head>
    <body id="page1">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <div class="tail-cont">
            <div class="tail-top-left"></div>
            <div class="tail-top">
                <div class="container">
                    <!-- header -->
                    <div id="header">
                        <div class="logo"><a href="#"><img src="styles/images/logo.jpg" alt="" /></a></div>

                        <ul class="site-nav">
                            <li><a href="index.html" class="act">Home</a></li>


                            <li><a href="contact-us.html">Contact Us</a></li>



                        </ul>
                        <ul class="log">

                            <div class="g-signin2" data-onsuccess="onSignIn"></div>



                            <script>
                                function onSignIn(googleUser) {
                                    var profile = googleUser.getBasicProfile();

                                    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
                                    console.log('Name: ' + profile.getName());
                                    console.log('Image URL: ' + profile.getImageUrl());
                                    console.log('Email: ' + profile.getEmail());
                                    // document.write("ID: " + profile.getId() +"\n"+"Name: " + profile.getName()+"\n"+"Email: " + profile.getEmail());
                                    alert("ID: " + profile.getId() + "\nName: " + profile.getName() + "\n" + "Email: " + profile.getEmail());
                                    // w=window.open;


                                    document.getElemenetById("notguest").innerHTML = "Hello," + profile.getName();
                                }


                            </script>



                            <form method="POST" action="login.do" >  
                                <label><b>Username</b></label>
                                <input type="text" placeholder="Enter Username" name="user">

                                    <label><b>Password</b></label>
                                    <input type="password" placeholder="Enter Password" name="passwd" >

                                        <button type="submit">Login</button>
                                        </form>
                                        <form method="POST" action ="register.do">
                                            <label><b>Username</b></label>
                                            <input type="text" placeholder="Enter Username" name="user">

                                                <label><b>Password</b></label>
                                                <input type="password" placeholder="Enter Password" name="passwd" >

                                                    <button type="submit">Register</button>
                                                    </form>
                                                    </ul>
                                                    </div>
                                                    <!-- content -->
                                                    <div id="content">
                                                        <div class="indent">
                                                            <div class="indent1">
                                                                <h2>Welcome to Our Music Site, <%= session.getAttribute("usr")%> </h2>
                                                                <h3 id="notguest"></h3>
                                                                <form method="get" action="ch.do">


                                                                    <h2> <input type="search" name="q" />
                                                                        <select name="type"size="1">
                                                                            <option>track</option>
                                                                            
                                                                        </select>


                                                                    </h2>

                                                                </form>
                                                                <h3>
                                                                <form method="get" action="MyHistory.do" style="display:inline;">


                                                                    <input type="submit" value="History" style="height:50px; width:150px"/>


                                                                </form>
                                                                </h3>


                                                            </div>


                                                        </div>

                                                    </div>
                                                    </div>
                                                    </div>

                                                    </div>

                                                    </body>
                                                    </html>
