import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import xiangcefenleiList from '../pages/xiangcefenlei/list'
import xiangcefenleiDetail from '../pages/xiangcefenlei/detail'
import xiangcefenleiAdd from '../pages/xiangcefenlei/add'
import xiangcexinxiList from '../pages/xiangcexinxi/list'
import xiangcexinxiDetail from '../pages/xiangcexinxi/detail'
import xiangcexinxiAdd from '../pages/xiangcexinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'xiangcefenlei',
					component: xiangcefenleiList
				},
				{
					path: 'xiangcefenleiDetail',
					component: xiangcefenleiDetail
				},
				{
					path: 'xiangcefenleiAdd',
					component: xiangcefenleiAdd
				},
				{
					path: 'xiangcexinxi',
					component: xiangcexinxiList
				},
				{
					path: 'xiangcexinxiDetail',
					component: xiangcexinxiDetail
				},
				{
					path: 'xiangcexinxiAdd',
					component: xiangcexinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
