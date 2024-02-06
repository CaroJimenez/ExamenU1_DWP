<template>
  <div>
    <div class="navbar">
      <b-navbar toggleable="lg" type="dark" variant="primary">
        <b-navbar-brand href="#">NavBar</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="#/">Land Page</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <div class="breadcrumb">
      <br />
      <b-breadcrumb :items="items"></b-breadcrumb>
    </div>
    <div class="title"><h1>FORMULARIO</h1></div>

    <b-sidebar
      id="sidebar-no-header"
      aria-labelledby="sidebar-no-header-title"
      no-header
      shadow
      visible
    >
      <template #default="{ hide }">
        <div class="p-3">
          <h4 id="sidebar-no-header-title">Sidebar del sitio</h4>
          <p>
            Cras mattis consectetur purus sit amet fermentum. Cras justo odio,
            dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta
            ac consectetur ac, vestibulum at eros.
          </p>
          <nav class="mb-3">
            <b-nav vertical>
              <b-nav-item href="#/formulario" @click="hide"
                >Formulario</b-nav-item
              >
              <b-nav-item href="#/paginacion" @click="hide"
                >Paginación</b-nav-item
              >
            </b-nav>
          </nav>
        </div>
      </template>
    </b-sidebar>
    <b-breadcrumb :items="items"></b-breadcrumb>

    <div class="form">
      <b-container>
        <div>
          <b-form
            @submit.prevent="checkForm"
            action="https://vuejs.org/"
            method="post"
            novalidate
          >
            <b-alert variant="danger" dismissible :show="errors.length > 0">
              <b>{{
                errors.length > 1
                  ? "Please correct the following errors:"
                  : "Please correct the following error:"
              }}</b>
              <ul>
                <li v-for="error in errors" :key="error">{{ error }}</li>
              </ul>
            </b-alert>

            <b-form-group
              id="marca-group"
              label="Marca"
              label-for="marca"
              :state="marca ? null : false"
            >
              <b-form-input
                id="marca"
                v-model="marca"
                type="text"
                name="marca"
                required
                pattern="[a-zA-Z0-9]+"
              ></b-form-input>
            </b-form-group>

            <b-form-group
              id="modelo-group"
              label="Modelo"
              label-for="modelo"
              :state="modelo ? null : false"
            >
              <b-form-input
                id="modelo"
                v-model="modelo"
                type="text"
                name="modelo"
                required
                pattern="[a-zA-Z0-9]+"
              ></b-form-input>
            </b-form-group>

            <b-form-group
              id="anio-group"
              label="Año de Fabricación"
              label-for="anio"
              :state="validAnio(anio) ? null : false"
            >
              <b-form-input
                id="anio"
                v-model="anio"
                type="number"
                name="anio"
                required
                :max="getCurrentYear()"
              ></b-form-input>
            </b-form-group>

            <b-form-group
              id="serie-group"
              label="Número de Serie"
              label-for="serie"
              :state="validSerie(serie) ? null : false"
            >
              <b-form-input
                id="serie"
                v-model="serie"
                type="text"
                name="serie"
                required
                pattern="[A-Za-z]{4}[0-9]{3}-[0-9]{2}[A-Za-z]{2}"
              ></b-form-input>
            </b-form-group>

            <b-button @click="submitForm" type="submit" variant="primary"
              >Enviar</b-button
            >
          </b-form>
        </div>
      </b-container>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import axios from "axios";
import POST_URL from "../components/Network";
export default Vue.extend({
  mounted() {
    this.$refs.sidebar.show();
  },
  data() {
    return {
      items: [
        {
          text: "Anterior",
          href: "#/inicio",
          to: "inicio",
        },
        {
          text: "Siguiente",
          href: "#/paginacion",
          to: "paginacion",
        },
        {
          text: "formulario",
          href: "#",
        },
      ],
      errors: [],
      marca: null,
      modelo: null,
      anio: null,
      serie: null,
      formData: {
        marca: "",
        modelo: "",
        anio: "",
        serie: "",
      },
    };
  },
  methods: {
    submitForm() {
      if (this.marca && this.modelo && this.anio && this.serie) {
        axios
          .post(POST_URL, {
            brand: this.marca,
            model: this.modelo,
            serie: this.serie,
            year: this.anio,
          })
          .then((response) => {
            console.log(response);
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    getCurrentYear() {
      return new Date().getFullYear();
    },
    checkForm: function (e) {
      this.errors = [];

      if (!this.marca) {
        this.errors.push("Marca requerida.");
      }

      if (!this.modelo) {
        this.errors.push("Modelo requerido.");
      }

      if (!this.anio) {
        this.errors.push("Año de fabricación requerido.");
      } else if (this.anio > new Date().getFullYear()) {
        this.errors.push("Año de fabricación no puede ser mayor al actual.");
      }

      if (!this.serie) {
        this.errors.push("Número de serie requerido.");
      } else if (!this.validSerie(this.serie)) {
        this.errors.push("Número de serie inválido.");
      }

      if (!this.errors.length) {
        return true;
      }

      e.preventDefault();
    },
    validEmail: function (email) {
      var re =
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      return re.test(email);
    },
    validAnio: function (anio) {
      return anio <= new Date().getFullYear();
    },
    validSerie: function (serie) {
      var re = /^[A-Za-z]{4}[0-9]{3}-[0-9]{2}[A-Za-z]{2}$/;
      return re.test(serie);
    },
  },
});
</script>

<style scoped>
.navbar {
  position: fixed;
  top: 0;
  right: 0;
  left: 0;
  z-index: 1030;
  padding: 0.5rem 1rem;
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
  width: 100%;
  margin-left: 22%;
}
.breadcrumb {
  position: fixed;
  top: 3.5rem;
  right: 0;
  left: 0;
  z-index: 1030;
  padding: 0.5rem 1rem;
  box-shadow: 0 0.5rem 1rem rgba(152, 152, 152, 0.15);
  width: 100%;
  margin-left: 22%;
}
.title {
  position: fixed;
  margin-top: -20%;
  width: 100%;
  margin-left: 23%;
}
.form {
  position: fixed;
  margin-top: -13%;
  width: 50%;
  margin-left: 23%;
}
</style>
