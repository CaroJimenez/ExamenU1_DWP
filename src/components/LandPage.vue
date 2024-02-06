<template>
  <div id="app">
    <header>
      <h1>Bienvenido a nuestro sitio</h1>
    </header>

    <main>
      <div class="hero">
        <img
          src="https://www.abgam.es/wp-content/uploads/2020/11/VEHICULO-INTELIGENTE.jpg"
          alt="Hero Image"
        />
      </div>

      <div class="content">
        <h2>Descubre nuevos mundos</h2>
        <p>Encuentra la más reciente tecnología!</p>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget
          condimentum libero. Donec nec commodo eros. Integer auctor
          sollicitudin justo, a efficitur ex placerat et. Fusce vel fermentum
          lorem.
        </p>
      </div>

      <router-link to="/inicio" class="btn">Ir al inicio</router-link>
    </main>

    <footer>
      <p>&copy; 2024 Our Company. All rights reserved.</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
#app {
  font-family: Arial, sans-serif;
}

header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  background-color: #333;
  color: #fff;
  padding: 20px 0;
  text-align: center;
}

main {
  margin-top: 80px;
  margin-bottom: 40px;
  padding: 20px;
}

footer {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  background-color: #333;
  color: #fff;
  padding: 10px 0;
  text-align: center;
}

.hero img {
  width: 100%;
  max-width: 100%;
  height: auto;
}

.content {
  margin-top: 20px;
}

.btn {
  display: inline-block;
  background-color: #007bff;
  color: #fff;
  padding: 10px 20px;
  text-decoration: none;
  border-radius: 5px;
}
</style>
