import apiClient from '../client';

// Login API request function
export const login = async (email, password) => {
  const response = await apiClient.post('/auth/login', {
    email,
    password,
  });
  return response.data;  // Assuming the API returns an object with a token
};