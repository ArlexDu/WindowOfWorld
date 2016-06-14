<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>The World Window</title>

    <link href="../assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../assets/css/agency.css" rel="stylesheet">
	<link href="../assets/wow-font/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
       
    <!-- New -->
    <link href="../assets/css/new.css" rel="stylesheet">
</head>

<body id="page-top" class="index">

    <!-- 标题栏 -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header page-scroll">
                <a class="navbar-brand page-scroll" href="#">世界之窗</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">产品</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#portfolio">活动</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#team">团队</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="login.jsp">登录</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#AppModal" data-toggle="modal">App</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">欢迎加入世界之窗</div>
                <a href="#services" class="page-scroll btn btn-xl">了解更多</a>
            </div>
        </div>
    </header>

    <!-- 产品介绍 -->
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">产品</h2>
                    <h3 class="section-heading">一个全新的车载广告系统！</h3>
                    <h3 class="section-subheading text-muted"></h3>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-users fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">个性化</h4>
                    <p class="text-muted">世界之窗车载广告系统让你在自己的汽车上展现自己的个性！</p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-money fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">商业广告</h4>
                    <p class="text-muted">通过世界之窗车载广告系统发布广告，享受更高的利润，更全面，更方便的赚钱！</p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-heart fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">公益</h4>
                    <p class="text-muted">在您的汽车上发布公益广告，传递您的爱心！</p>
                </div>
            </div>
        </div>
    </section>

    <!-- 活动介绍 ，包含6个-->
    <section id="portfolio" class="bg-light-gray">
        <div class="container">
             <div class="col-lg-12 text-center">
                 <h2 class="section-heading">活动</h2>
                 <h3 class="section-subheading text-muted"></h3>
             </div>
            <div class="row">
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="../assets/images/portfolio/roundicons.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>活动标题</h4>
                        <p class="text-muted">Web Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="../assets/images/portfolio/startup-framework.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>活动标题</h4>
                        <p class="text-muted">Web Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="../assets/images/portfolio/treehouse.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>活动标题</h4>
                        <p class="text-muted">Web Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="../assets/images/portfolio/golden.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>活动标题</h4>
                        <p class="text-muted">Web Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="../assets/images/portfolio/escape.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>活动标题</h4>
                        <p class="text-muted">Web Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="../assets/images/portfolio/dreams.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>活动标题</h4>
                        <p class="text-muted">Web Design</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- 团队 -->
    <section id="team" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">我们的开发团队</h2>
                    <h3 class="section-heading">我们全新全意，愿您十分满意！</h3>
                    <h3 class="section-subheading text-muted"></h3>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="../assets/images/team/1.jpg" class="img-responsive img-circle" alt="">
                        <h4>黄日辉</h4>
                        <p class="text-muted">组长</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="../assets/images/team/2.jpg" class="img-responsive img-circle" alt="">
                        <h4>杜盛瑀</h4>
                        <p class="text-muted">Web组组长</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="team-member">
                        <img src="../assets/images/team/3.jpg" class="img-responsive img-circle" alt="">
                        <h4>李冠华</h4>
                        <p class="text-muted">大机一霸</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h4>专业综合第四小组</h4>
                </div>
            </div>
        </div>
    </section>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">Our Web 2016</span>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-arrow-circle-up"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>

	<!-- 活动部分详情 -->
    <!-- 活动1 -->
    <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
        	<div class="row">
                 <div class="col-lg-8 col-lg-offset-2">
                     <div class="modal-body">
                         <h2>活动标题</h2>
                         <p class="item-intro text-muted">副标题.</p>
                         <img class="img-responsive img-centered" src="../assets/images/portfolio/roundicons-free.png" alt="">
                         <p>活动内容</p>
                         <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                     </div>
                 </div>
            </div>
        </div>
    </div>

    <!-- 活动 2 -->
    <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
        	<div class="row">
                 <div class="col-lg-8 col-lg-offset-2">
                     <div class="modal-body">
                         <h2>活动标题</h2>
                         <p class="item-intro text-muted">副标题.</p>
                         <img class="img-responsive img-centered" src="../assets/images/portfolio/startup-framework-preview.png" alt="">
                         <p>活动内容</p>
                         <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                     </div>
                 </div>
            </div>
        </div>
    </div>

    <!-- 活动 3 -->
    <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
        	<div class="row">
                 <div class="col-lg-8 col-lg-offset-2">
                     <div class="modal-body">
                         <h2>活动标题</h2>
                         <p class="item-intro text-muted">副标题.</p>
                         <img class="img-responsive img-centered" src="../assets/images/portfolio/treehouse-preview.png" alt="">
                         <p>活动内容</p>
                         <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                     </div>
                 </div>
            </div>
        </div>
    </div>

    <!-- 活动 4 -->
    <div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
    	<div class="modal-content">
        	<div class="row">
                 <div class="col-lg-8 col-lg-offset-2">
                     <div class="modal-body">
                         <h2>活动标题</h2>
                         <p class="item-intro text-muted">副标题.</p>
                         <img class="img-responsive img-centered" src="../assets/images/portfolio/golden-preview.png" alt="">
                         <p>活动内容</p>
                         <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                     </div>
                 </div>
            </div>
        </div>
    </div>

    <!-- 活动 5 -->
    <div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
    	<div class="modal-content">
        	<div class="row">
                 <div class="col-lg-8 col-lg-offset-2">
                     <div class="modal-body">
                         <h2>活动标题</h2>
                         <p class="item-intro text-muted">副标题.</p>
                         <img class="img-responsive img-centered" src="../assets/images/portfolio/escape-preview.png" alt="">
                         <p>活动内容</p>
                         <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                     </div>
                 </div>
            </div>
        </div>
    </div>

    <!-- 活动 6 -->
    <div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
        	<div class="row">
                 <div class="col-lg-8 col-lg-offset-2">
                     <div class="modal-body">
                         <h2>活动标题</h2>
                         <p class="item-intro text-muted">副标题.</p>
                         <img class="img-responsive img-centered" src="../assets/images/portfolio/dreams-preview.png" alt="">
                         <p>活动内容</p>
                         <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                     </div>
                 </div>
            </div>
        </div>
    </div>
    
    <!--APP二维码-->
    <div class="portfolio-modal modal fade" id="AppModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <h2>扫二维码下载APP</h2>
                        <img class="img-responsive img-centered" src="../assets/images/erweima.png" alt="">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">关      闭</button>
                    </div>
            </div>
        </div>
    </div>

    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/js/jquery.easing.min.js"></script>
    <script src="../assets/js/classie.js"></script>
    <script src="../assets/js/cbpAnimatedHeader.js"></script>
    <script src="../assets/js/jqBootstrapValidation.js"></script>
    <script src="../assets/js/contact_me.js"></script>
    <script src="../assets/js/agency.js"></script>

</body>

</html>
