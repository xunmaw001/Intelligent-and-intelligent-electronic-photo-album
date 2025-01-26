<template>
	<div class="main-containers">
		<div class="top-container" :style='{"boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","padding":"0 7%","alignItems":"center","display":"flex","justifyContent":"space-between","overflow":"hidden","top":"0","left":"0","background":"url(http://codegen.caihongy.cn/20230206/544f501163914411bf89e5cb898e10ac.png) no-repeat left bottom,radial-gradient(circle, rgba(142,215,235,1) 0%, rgba(64,168,196,1) 100%),#40a8c4","width":"100%","position":"fixed","height":"64px","zIndex":"1002"}'>
			<img v-if='false' :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"block","height":"44px"}' src='http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg'>
			<div v-if="true" :style='{"color":"#000","margin":"0","fontSize":"22px"}'>智能化智能化电子相册</div>
			<div>
				<div v-if="false" :style='{"color":"#333","fontSize":"16px","display":"inline-block"}'>0753-1234567</div>
				<div v-if="Token" :style='{"color":"#333","fontSize":"16px","display":"inline-block"}'>{{username}}</div>
				<el-button v-if="!Token" @click="toLogin()" :style='{"border":"none","padding":"0 20px","margin":"0 0 0 10px","color":"#fff","borderRadius":"2px","background":"#f2855e","display":"inline-block","fontSize":"14px","lineHeight":"32px","minWidth":"80px","height":"32px"}'>登录/注册</el-button>
                <el-button v-if="Token" @click="logout" :style='{"border":"none","padding":"0 20px","margin":"0 0 0 10px","color":"#666","borderRadius":"2px","background":"#d7eef2","display":"inline-block","fontSize":"14px","lineHeight":"32px","minWidth":"80px","height":"32px"}'>退出</el-button>
			</div>
		</div>
		
		
		<div class="body-containers" :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"rgba(64, 158, 255, .3)","display":"block"} : {"minHeight":"100vh","padding":"64px 0 0","margin":"0","position":"relative","background":"#fff"}'>
			<div class="menu-preview" :style='{"padding":"0 ","borderColor":"#efefef","margin":"64px auto 0","top":"0","background":"url(http://codegen.caihongy.cn/20230204/13e68e581e9e42b7a53fd23ab9faef74.png) no-repeat left top /100% 100%,#d7eef2","borderWidth":"0","width":"100%","position":"fixed","borderStyle":"solid","height":"44px","zIndex":"1002"}'>
				<el-menu class="el-menu-horizontal-demo" :style='{"border":0,"padding":"0","listStyle":"none","margin":"0","background":"none","display":"flex","position":"relative","justifyContent":"center"}' :default-active="activeIndex" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<el-image v-if="false" :style='{"width":"44px","margin":"8px 10px 8px 0","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					<el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"44px","fontSize":"14px","height":"44px"}' :class="iconArr[index]"></i>
						<span :style='{"padding":"0 10px","lineHeight":"44px","fontSize":"14px","color":"inherit","height":"44px"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item :index="menuList.length + 2 + ''" v-if="Token && notAdmin" @click="goMenu('/index/center')">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"44px","fontSize":"14px","height":"44px"}' class="el-icon-user"></i>
						<span :style='{"padding":"0 10px","lineHeight":"44px","fontSize":"14px","color":"inherit","height":"44px"}'>个人中心</span>
					</el-menu-item>
				</el-menu>
			</div>
			
			<div class="banner-preview" :style='{"width":"100%","padding":"106px 7% 20px","margin":"0 0 0","height":"auto"}'>
				<el-carousel :style='{"width":"86%","margin":"0 auto"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="680px" :autoplay="false" :interval="3000" :loop="true">
					<el-carousel-item :style='{"borderRadius":"10px","width":"100%","height":"100%"}' v-for="item in carouselList" :key="item.id">
						<el-image :style='{"border":"0 outset #bcdbdf","padding":"20px","objectFit":"cover","borderRadius":"0 0 60px 60px","background":"#fff","borderWidth":"0 16px 16px","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			
			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"minHeight":"150px","padding":"20px 0","alignItems":"center","background":"#235784","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center"}'>
			    <img :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" >
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Vue from 'vue'
export default {
    data() {
		return {
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"相册分类","menuJump":"列表","tableName":"xiangcefenlei"}],"menu":"相册分类管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["新增","查看","修改","删除","查看评论"],"menu":"相册信息","menuJump":"列表","tableName":"xiangcexinxi"}],"menu":"相册信息管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"新闻资讯","tableName":"news"},{"appFrontIcon":"cuIcon-similar","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","查看评论"],"menu":"相册信息列表","menuJump":"列表","tableName":"xiangcexinxi"}],"menu":"相册信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["新增","查看","修改","删除","查看评论"],"menu":"相册信息","menuJump":"列表","tableName":"xiangcexinxi"}],"menu":"相册信息管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","查看评论"],"menu":"相册信息列表","menuJump":"列表","tableName":"xiangcexinxi"}],"menu":"相册信息模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			Token: localStorage.getItem('Token'),
            username: localStorage.getItem('username'),
            notAdmin: localStorage.getItem('sessionTable')!='"users"',
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],	
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
        },
    },
    methods: {
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: '登出成功',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		goMenu(path) {
            if (!localStorage.getItem('Token')) {
                this.toLogin();
            } else {
                this.$router.push(path);
            }
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		color: #194769;
		white-space: nowrap;
		display: flex;
		font-size: 14px;
		line-height: 44px;
		background: none;
		align-items: center;
		position: relative;
		list-style: none;
		min-width: 110px;
		height: 44px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		color: #fff;
		white-space: nowrap;
		background: #40a8c4;
		font-size: 14px;
		line-height: 44px;
		position: relative;
		list-style: none;
		min-width: 110px;
		height: 44px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		color: #fff;
		white-space: nowrap;
		background: #40a8c4;
		font-size: 14px;
		line-height: 44px;
		position: relative;
		list-style: none;
		min-width: 110px;
		height: 44px;
	}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: #abb340;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: #abb340;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
      .left-content {
          width: 100%;
          text-align: left;
      }
      .right-content {
          width: 100%;
          text-align: right;
      }
    }
</style>
