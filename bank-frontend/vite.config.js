import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

// Vite config
export default defineConfig({
  server: {
    port: 3000, // Ensure the app runs on port 3000 as expected
  },
  plugins: [react()],
});
