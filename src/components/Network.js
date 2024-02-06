import axios from "axios";
let GET_URL = "http://localhost:8080/api/vehiculos/page";
export let POST_URL = "http://localhost:8080/api/vehiculos";

const obtenerVehiculosPaginados = async (page, size, sort) => {
  const params = {
    page,
    size,
    sort,
  };
  try {
    const response = await axios.post(GET_URL, null, { params });

    return response.data;
  } catch (error) {
    throw error;
  }
};

export default {
  obtenerVehiculosPaginados,
};
