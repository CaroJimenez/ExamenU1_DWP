import VueRouter from "vue-router";
import Vue from "vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: () => import("../components/LandPage.vue"),
  },
  {
    path: "/inicio",
    component: () => import("../components/Inicio.vue"),
  },
  {
    path: "/formulario",
    component: () => import("../components/Formulario.vue"),
  },
  {
    path: "/paginacion",
    component: () => import("../components/Pagination.vue"),
  },
];

const router = new VueRouter({ routes });
export default router;
