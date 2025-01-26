<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","width":"100%","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20230207/860aeea5c04f45119e98c796e63dee11.jpg) no-repeat right bottom / 100% auto,#fff","justifyContent":"flex-end","display":"flex"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"border":"8px outset #bcdbdf","padding":"20px","boxShadow":"0 0px 0px rgba(64, 158, 255, .8)","margin":"5% 7% 0 0","borderRadius":"0","flexWrap":"wrap","background":"rgba(255,255,255,.9)","display":"flex","width":"800px","position":"relative","justifyContent":"center","height":"auto"}' :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"margin":"4px 0 40px","color":"#333","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230204/13e68e581e9e42b7a53fd23ab9faef74.png) no-repeat left top /100% 100%,#d7eef2","width":"100%","lineHeight":"44px","fontSize":"16px","textShadow":"0px 0px 0px rgba(64, 158, 255, .5)"}'>智能化智能化电子相册登录</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 0 20px","flexWrap":"wrap","display":"flex"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>账号：</div>
				<input :style='{"border":"1px solid #eee","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","outline":"0px solid #efefef","color":"#333","width":"100%","fontSize":"14px","height":"40px"}' v-model="loginForm.username" placeholder="请输入账户">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 0 20px","flexWrap":"wrap","display":"flex"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
				<input :style='{"border":"1px solid #eee","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","outline":"0px solid #efefef","color":"#333","width":"100%","fontSize":"14px","height":"40px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"80%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"40%","margin":"120px auto 20px","position":"relative"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 auto","color":"#333","textAlign":"center","letterSpacing":"4px","outline":"none","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20230204/dee7aa1825b6499695c40e2e5a76dd9c.png) repeat-x center bottom,linear-gradient(0deg, rgba(182,215,222,1) 0%, rgba(233,248,251,1) 80%, rgba(207,237,244,1) 100%),#b6d7de","width":"auto","fontSize":"24px","lineHeight":"40px","height":"120px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 30px","margin":"0","outline":"none","color":"#333","borderRadius":"4px","background":"none","width":"20px","fontSize":"18px","lineHeight":"1.5","height":"auto"}' @click="resetForm('loginForm')">重置</el-button>
                <el-upload v-if="loginType==2" :action="baseUrl + 'file/upload'" :show-file-list="false" :on-success="faceLogin">
                    <el-button :style='{"border":"0","cursor":"pointer","padding":"0 20px","margin":"0 auto","color":"#333","textAlign":"center","letterSpacing":"4px","outline":"none","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20230204/dee7aa1825b6499695c40e2e5a76dd9c.png) repeat-x center bottom,linear-gradient(0deg, rgba(182,215,222,1) 0%, rgba(233,248,251,1) 80%, rgba(207,237,244,1) 100%),#b6d7de","width":"auto","fontSize":"24px","lineHeight":"40px","height":"120px"}'>人脸识别登录</el-button>
                </el-upload>
			</el-form-item>
			<div :style='{"width":"80%","margin":"20px auto","position":"absolute","bottom":"200px","justifyContent":"center","display":"flex"}'>
			<router-link :style='{"cursor":"pointer","margin":"0 10px 10px 0","color":"#333","textAlign":"center","background":"none","fontSize":"16px","textDecoration":"none","minWidth":"100px"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>

export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["新增","查看","修改","删除"],"menu":"相册分类","menuJump":"列表","tableName":"xiangcefenlei"}],"menu":"相册分类管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["新增","查看","修改","删除","查看评论"],"menu":"相册信息","menuJump":"列表","tableName":"xiangcexinxi"}],"menu":"相册信息管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"新闻资讯","tableName":"news"},{"appFrontIcon":"cuIcon-similar","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-form","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","查看评论"],"menu":"相册信息列表","menuJump":"列表","tableName":"xiangcexinxi"}],"menu":"相册信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["新增","查看","修改","删除","查看评论"],"menu":"相册信息","menuJump":"列表","tableName":"xiangcexinxi"}],"menu":"相册信息管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","查看评论"],"menu":"相册信息列表","menuJump":"列表","tableName":"xiangcexinxi"}],"menu":"相册信息模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='是') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: '登录成功',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20230207/860aeea5c04f45119e98c796e63dee11.jpg) no-repeat right bottom / 100% auto,#fff;
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 1px solid #eee;
			padding: 0 10px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .5);
			outline: 0px solid #efefef;
			color: #333;
			width: 100%;
			font-size: 14px;
			height: 40px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 1px solid #eee;
			padding: 0 10px;
			outline: none;
			color: #333;
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 110px);
			font-size: 14px;
			height: 40px;
		}
		
		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #999;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: #333;
			border-color: #333;
		}
		.list-type /deep/ .el-radio__label {
			color: #999;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #333;
			font-size: 14px;
		}
	}
</style>
