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
    <div class="title">
      <h1>PAGINACIÓN</h1>
      <div>
        <b-container class="mt-5">
          <b-input placeholder="Buscar coche" v-model="filtro"></b-input>
          <b-table
            id="my-table"
            :items="obtenervehiculos"
            :per-page="perPage"
            :current-page="currentPage"
            :fields="fields"
            :sort-by.sync="sortBy"
            :sort-desc.sync="sortDesc"
            label-sort-asc=""
            label-sort-desc=""
            small
            :filter="filtro"
            @filtered="onFiltered"
          >
          </b-table>
          <div class="overflow-auto">
            <b-pagination
              v-model="currentPage"
              :total-rows="rows"
              :per-page="perPage"
              aria-controls="my-table"
            ></b-pagination>

            <p class="mt-3">Current Page: {{ currentPage }}</p>
          </div>
        </b-container>
      </div>
    </div>

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
  </div>
</template>

<script>
import vehiculoService from "./Network";
export default {
  mounted() {
    this.$refs.sidebar.show();
  },
  data() {
    return {
      items: [
        {
          text: "Anterior",
          href: "#/formulario",
          to: "formulario",
        },
        {
          text: "Siguiente",
          href: "#/",
        },
        {
          text: "Paginación",
          href: "#",
        },
      ],
      filtro: null,
      sortBy: "model",
      sortDesc: false,
      perPage: 5,
      rows: 0,
      currentPage: 1,
      vehiculos: [],
      fields: [
        { key: "brand", label: "Marca", sortable: true },
        { key: "model", label: "Modelo", sortable: true },
        { key: "serie", label: "Serie", sortable: true },
        { key: "year", label: "Año", sortable: true },
      ],
    };
  },
  methods: {
    async obtenervehiculos(ctx) {
      console.log(ctx);
      try {
        const data = await vehiculoService.obtenerVehiculosPaginados(
          parseInt(ctx.currentPage) - 1,
          parseInt(ctx.perPage),
          ctx.sortBy
        );
        this.rows = data.totalElements;
        return data.content;
      } catch (error) {
        console.error(error);
        // Manejar errores (puedes mostrar un mensaje de error al usuario, por ejemplo)
      }
    },
    onFiltered(filteredItems) {
      this.currentPage = 1;
      this.rows = filteredItems.length;
    },
  },
};
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
</style>
