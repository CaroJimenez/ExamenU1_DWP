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
    <div class="title"><h1>INICIO</h1></div>

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
    tercero
  </div>
</template>

<script>
export default {
  mounted() {
    this.$refs.sidebar.show();
  },
  data() {
    return {
      items: [
        {
          text: "Anterior",
          href: "#/",
        },
        {
          text: "Siguiente",
          href: "#/formulario",
          to: "formulario",
        },
        {
          text: "Inicio",
          href: "#",
        },
      ],
    };
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
