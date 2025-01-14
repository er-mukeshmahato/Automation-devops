// src/hooks/useLogin.js
import { useMutation } from '@tanstack/react-query';
import { login } from '../api/endpoints/auth';  // Import the login API function

// Custom hook for logging in a user
const useLogin = () => {
  return useMutation(async ({ email, password }) => {
    const data = await login(email, password);  // Call the login API
    // Store token in localStorage upon success
    localStorage.setItem('token', data.token);
    return data;
  });
};

export default useLogin;
