// src/api/endpoints/users.js
import apiClient from '../client';

// Fetch all users
export const getUsers = () => {
  return apiClient.get('/users/');  // Makes a GET request to '/users'
};

// Fetch a specific user by ID
export const getUserById = (id) => {
  return apiClient.get(`/users/${id}`);  // Makes a GET request to '/users/{id}'
};
