import axios from 'axios';

const API_BASE_URL = "http://localhost:8080/api";



export const deleteEmployee = (id) => axios.delete(`${API_BASE_URL}/employee/${id}`);
export const getEmployees = () => axios.get(`${API_BASE_URL}/employees`);
export const addEmployee = (employee) => axios.post(`${API_BASE_URL}/employee`, employee);
export const getEmployeeById = (id) => axios.get(`${API_BASE_URL}/employee/${id}`);
export const updateEmployee = (employee, id) => axios.put(`${API_BASE_URL}/employee/${id}`, employee);
