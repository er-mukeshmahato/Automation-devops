


import axios from 'axios';

// // Create Axios instance with custom configuration
// const apiClient = axios.create({
//   baseURL: 'http://localhost:8080/api',  // Base URL for your API
//   headers: {
//     'Content-Type': 'application/json',
//   },
// });

// // Request interceptor to add the auth token (if available)
// apiClient.interceptors.request.use(
//   (config) => {
//     const token = localStorage.getItem('token');  // Get token from localStorage (or from a state/store)
//     if (token) {
//       config.headers.Authorization = `Bearer ${token}`;  // Attach token to request headers
//     }
//     return config;
//   },
//   (error) => {
//     return Promise.reject(error);  // Handle request error
//   }
// );

// // Response interceptor to handle errors like 401 Unauthorized globally
// apiClient.interceptors.response.use(
//   (response) => response,
//   (error) => {
//     if (error.response && error.response.status === 401) {
//       // Redirect user to login page or show a notification
//       console.error('Unauthorized. Please log in again.');
//       // Handle logout or token refresh if required
//     }
//     return Promise.reject(error);
//   }
// );

export default apiClient;
