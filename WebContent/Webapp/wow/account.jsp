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
    <link href="../assets/css/new.css" rel="stylesheet">
</head>

<body id="page-top" class="index">
    <!-- 菜单栏-->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header page-scroll">
                <a class="navbar-brand page-scroll" href="#">个人主页</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="upload.jsp">上传广告</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="owner.jsp">个人信息</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="home.jsp">退出</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#">App</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">Hello!XXX</div>
                <div class="intro-heading">欢迎进入个人主页</div>
            </div>
        </div>
    </header>

    <!-- 活动 -->
    <section id="portfolio" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">近期活动</h2>
                    <h3 class="section-subheading text-muted"></h3>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover"></div>
                        <img src="../assets/images/portfolio/roundicons.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>活动标题</h4>
                        <p class="text-muted">Web Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover"></div>
                        <img src="../assets/images/portfolio/startup-framework.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>活动标题</h4>
                        <p class="text-muted">Web Design</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover"></div>
                        <img src="../assets/images/portfolio/treehouse.png" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>活动标题</h4>
                        <p class="text-muted">Web Design</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <!-- 广告罗列 -->
    <section id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">最新广告</h2>
                    <h3 class="section-subheading text-muted"></h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <ul class="timeline ad_time">
                        <li>
                            <div class="timeline-image">
                            <a href="#adtimeModal1" data-toggle="modal">
		                        <img class="img-circle img-responsive" src="../assets/images/about/1.jpg" alt="">
                    		</a>
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>2016-3-1到2016-3-2</h4>
                                    <h4 class="subheading">广告标题</h4>
                                </div>
                                <div class="timeline-body">
                                    <p class="text-muted">广告内容！</p>
                                </div>
                            </div>
                        </li>
                        <li class="timeline-inverted">
                            <div class="timeline-image">
                                <img class="img-circle img-responsive" src="../assets/images/about/2.jpg" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>2016-3</h4>
                                    <h4 class="subheading">广告标题</h4>
                                </div>
                                <div class="timeline-body">
                                    <p class="text-muted">广告内容！</p>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="timeline-image">
                                <img class="img-circle img-responsive" src="../assets/images/about/3.jpg" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>2016-4</h4>
                                    <h4 class="subheading">广告标题</h4>
                                </div>
                                <div class="timeline-body">
                                    <p class="text-muted">广告内容！</p>
                                </div>
                            </div>
                        </li>
                        <li class="timeline-inverted">
                            <div class="timeline-image">
                                <img class="img-circle img-responsive" src="../assets/images/about/4.jpg" alt="">
                            </div>
                            <div class="timeline-panel">
                                <div class="timeline-heading">
                                    <h4>2016-4</h4>
                                    <h4 class="subheading">广告标题</h4>
                                </div>
                                <div class="timeline-body">
                                    <p class="text-muted">广告内容！</p>
                                </div>
                            </div>
                        </li>
                        <li class="timeline-inverted">
                            <div class="timeline-image">
                                <h4>更多广告<br>敬请期待!</h4>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    
    <!--广告发布历史-->
    <section id="portfolio" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">广告发布历史</h2>
                    <h2 class="section-heading">&nbsp;</h2>
                </div>
            </div>
            <div class="row">
	        <table class="table table-hover table-bordered">
			<tr class="table-header">
				<td style="width:10%;">广告编号</td>
				<td style="width:50%;">广告内容</td>
				<td style="width:10%;">发布日期</td>
				<td style="width:10%;">截止日期</td>
				<td style="width:10%;">金额</td>
				<td style="width:10%;" colspan="2">操作</td>
			</tr>
			<tr>
				<td>1</td>
				<td>专业综合</td>
				<td>2016.3.1</td>
				<td>2016.4.1</td>
				<td>5</td>
				<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
				<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
			</tr>
			<tr>
				<td>2</td>
				<td>专业综合</td>
				<td>2016.3.1</td>
				<td>2016.4.1</td>
				<td>5</td>
				<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
				<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
			</tr>
			<tr>
				<td>3</td>
				<td>专业综合</td>
				<td>2016.3.1</td>
				<td>2016.4.1</td>
				<td>5</td>
				<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
				<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
			</tr>
			<tr>
				<td>4</td>
				<td>专业综合</td>
				<td>2016.3.1</td>
				<td>2016.4.1</td>
				<td>5</td>
				<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
				<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
			</tr>
			<tr>
				<td>5</td>
				<td>专业综合</td>
				<td>2016.3.1</td>
				<td>2016.4.1</td>
				<td>5</td>
				<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
				<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
			</tr>
			<tr>
				<td>6</td>
				<td>专业综合</td>
				<td>2016.3.1</td>
				<td>2016.4.1</td>
				<td>5</td>
				<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
				<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
			</tr>
			<tr>
				<td>7</td>
				<td>专业综合</td>
				<td>2016.3.1</td>
				<td>2016.4.1</td>
				<td>5</td>
				<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
				<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
			</tr>
			<tr>
				<td>8</td>
				<td>专业综合</td>
				<td>2016.3.1</td>
				<td>2016.4.1</td>
				<td>5</td>
				<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
				<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
			</tr>
			<tr>
				<td>9</td>
				<td>专业综合</td>
				<td>2016.3.1</td>
				<td>2016.4.1</td>
				<td>5</td>
				<td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
				<td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
			</tr>
			</table>
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
                         <!-- Project Details Go Here -->
                         <h2>Project Name</h2>
                         <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                         <img class="img-responsive img-centered" src="../assets/images/portfolio/roundicons-free.png" alt="">
                         <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                         <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
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
                      <h2>Project Heading</h2>
                      <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                      <img class="img-responsive img-centered" src="../assets/images/portfolio/startup-framework-preview.png" alt="">
                      <p><a href="http://designmodo.com/startup/?u=787">Startup Framework</a> is a website builder for professionals. Startup Framework contains components and complex blocks (PSD+HTML Bootstrap themes and templates) which can easily be integrated into almost any design. All of these components are made in the same style, and can easily be integrated into projects, allowing you to create hundreds of solutions for your future projects.</p>
                      <p>You can preview Startup Framework <a href="http://designmodo.com/startup/?u=787">here</a>.</p>
                      <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
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
                         <!-- Project Details Go Here -->
                         <h2>Project Name</h2>
                         <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                         <img class="img-responsive img-centered" src="../assets/images/portfolio/treehouse-preview.png" alt="">
                         <p>Treehouse is a free PSD web template built by <a href="https://www.behance.net/MathavanJaya">Mathavan Jaya</a>. This is bright and spacious design perfect for people or startup companies looking to showcase their apps or other projects.</p>
                         <p>You can download the PSD template in this portfolio sample item at <a href="http://freebiesxpress.com/gallery/treehouse-free-psd-web-template/">FreebiesXpress.com</a>.</p>
                         <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                     </div>
                 </div>
             </div>
        </div>
    </div>
    
    <!-- 1 -->
    <div class="portfolio-modal modal fade" id="adtimeModal1" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
             <div class="row">
                 <div class="col-lg-8 col-lg-offset-2">
                     <div class="modal-body">
                         <h2>Project Name</h2>
                         <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                         <img class="img-responsive img-centered" src="../assets/images/portfolio/treehouse-preview.png" alt="">
                         <p>This is bright and spacious design perfect for people or startup companies looking to showcase their apps or other projects.</p>
                         <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Close Project</button>
                     </div>
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
