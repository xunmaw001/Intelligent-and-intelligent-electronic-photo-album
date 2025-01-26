const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm84ds3/",
            name: "ssm84ds3",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm84ds3/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智能化智能化电子相册"
        } 
    }
}
export default base
