webpackJsonp([1],{"1k0i":function(e,t){},"8guK":function(e,t){},NHnr:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=r("7+uW"),o={name:"App",data:function(){return{activeIndex:"1"}},methods:{handleSelect:function(e,t){console.log(e,t)}}},a={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("el-container",[r("el-header",{staticStyle:{"line-height":"50px","text-align":"center","border-radius":"4px","background-color":"white",position:"fixed","z-index":"2",width:"100%",top:"0px",left:"0"}},[r("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":e.activeIndex,mode:"horizontal"},on:{select:e.handleSelect}},[r("el-menu-item",{attrs:{index:"1"}},[r("router-link",{attrs:{to:"/"}},[e._v("\n           아쿠아마린 🐳\n            ")])],1),e._v(" "),r("el-menu-item",{attrs:{index:"2"}},[e._v("클래스 🏄‍♀️")]),e._v(" "),r("el-menu-item",{attrs:{index:"5"}},[r("router-link",{attrs:{to:"/board"}},[e._v("자유 게시판 👨‍👨‍👧‍👧")])],1),e._v(" "),r("el-menu-item",{attrs:{index:"6"}},[e._v("로그인")])],1),e._v(" "),r("div",{staticClass:"line"})],1),e._v(" "),r("el-main",[r("br"),e._v(" "),r("br"),e._v(" "),r("router-view")],1),e._v(" "),r("el-footer",[r("div",{staticClass:"wrapCopyrightText"},[r("span",{staticClass:"copyrightText"},[e._v("\n            Copyright ©2022 AquaMarine Co., 대표자: 차정민\n          ")])])])],1)],1)},staticRenderFns:[]};var i=r("VU/8")(o,a,!1,function(e){r("wmdI")},null,null).exports,l=r("/ocq"),s={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{staticClass:"hello"},[t("br"),this._v(" "),t("router-link",{attrs:{to:"/board"}},[t("img",{attrs:{src:"https://pbs.twimg.com/media/E0rpfQ4UUAY1_ja.jpg"}})])],1)},staticRenderFns:[]};var u=r("VU/8")({name:"HelloWorld",data:function(){return{msg:"Welcome to Your Vue.js App"}}},s,!1,function(e){r("gTmv")},"data-v-79a01ba4",null).exports,c=r("Xxa5"),m=r.n(c),d=r("exGp"),p=r.n(d),b=r("mtWM"),v=r.n(b),f={name:"Board",data:function(){return{projectVersion:"게시판 목록v.12",bbsList:{}}},created:function(){var e=this;return p()(m.a.mark(function t(){return m.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return console.log("success!"),t.next=3,e.init();case 3:case"end":return t.stop()}},t,e)}))()},methods:{init:function(){var e=this;return p()(m.a.mark(function t(){return m.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,v.a.post("/api/native-query/board",{page:0,size:10}).then(function(t){console.log("res",t),e.bbsList=t.data.data.content}).catch(function(e){console.log(e)});case 2:case"end":return t.stop()}},t,e)}))()}}},h={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("br"),e._v(" "),r("div",{staticStyle:{"margin-right":"1400px"}},[r("router-link",{attrs:{to:"/board/write"}},[e._v("글 작성")])],1),e._v(" "),r("br"),e._v(" "),r("br"),e._v(" "),r("el-table",{staticStyle:{width:"auto"},attrs:{data:e.bbsList,border:""}},[r("el-table-column",{attrs:{property:"bname",label:"이름"}}),e._v(" "),r("el-table-column",{attrs:{property:"bcontent",label:"제목"}}),e._v(" "),r("el-table-column",{attrs:{property:"bcontent",label:"내용"}}),e._v(" "),r("el-table-column",{attrs:{property:"bdate",label:"작성시간"}})],1)],1)},staticRenderFns:[]};var _=r("VU/8")(f,h,!1,function(e){r("8guK")},"data-v-56d7da7d",null).exports,g={name:"BoardWrite",data:function(){return{userInfo:{loginStat:!1},ruleForm:{btitle:"",bname:"",bcontent:""},rules:{btitle:[{required:!0,message:"Please input Activity name",trigger:"blur"}],bname:[{required:!0,message:"Please input Activity name",trigger:"blur"}],bcontent:[{required:!0,message:"Please input activity name",trigger:"blur"}]}}},methods:{submitForm:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;v.a.post("/api/board/write",{btitle:t.ruleForm.btitle,bname:t.ruleForm.bname,bcontent:t.ruleForm.bcontent}).then(function(e){alert("작성 되었어요 :)"),console.log(e),t.$router.push("/board")}).catch(function(e){console.log("error"+e)})})},resetForm:function(e){this.$refs[e].resetFields()},gotoList:function(){this.$router.push("/board")}}},x={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("br"),e._v(" "),r("br"),e._v(" "),r("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"120px"}},[r("el-form-item",{attrs:{label:"이름",prop:"bname"}},[r("el-input",{model:{value:e.ruleForm.bname,callback:function(t){e.$set(e.ruleForm,"bname",t)},expression:"ruleForm.bname"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"제목",prop:"btitle"}},[r("el-input",{model:{value:e.ruleForm.btitle,callback:function(t){e.$set(e.ruleForm,"btitle",t)},expression:"ruleForm.btitle"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"내용",prop:"bcontent"}},[r("el-input",{attrs:{type:"textarea"},model:{value:e.ruleForm.bcontent,callback:function(t){e.$set(e.ruleForm,"bcontent",t)},expression:"ruleForm.bcontent"}})],1),e._v(" "),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("ruleForm")}}},[e._v("작성")]),e._v(" "),r("el-button",{on:{click:function(t){return e.resetForm("ruleForm")}}},[e._v("초기화")]),e._v(" "),r("el-button",{on:{click:e.gotoList}},[e._v("목록으로")])],1)],1)],1)},staticRenderFns:[]};var F=r("VU/8")(g,x,!1,function(e){r("1k0i")},"data-v-56f4f522",null).exports;n.default.use(l.a);var w=new l.a({mode:"history",routes:[{path:"/",name:"HelloWorld",component:u},{path:"/board",name:"Board",component:_},{path:"/board/write",name:"BoardWrite",component:F}]}),y=r("zL8q"),k=r.n(y);r("tvR6");n.default.use(k.a,{size:"small",zIndex:3e3}),n.default.config.productionTip=!1,new n.default({el:"#app",router:w,components:{App:i},template:"<App/>"})},gTmv:function(e,t){},tvR6:function(e,t){},wmdI:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.f906e5a4445a4efed713.js.map