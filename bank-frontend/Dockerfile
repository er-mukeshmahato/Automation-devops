# Step 1: Use an official Node.js image as the base image
FROM node:18-alpine as builder

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy package.json and package-lock.json (or npm-shrinkwrap.json) into the container
COPY package.json package-lock.json ./

# Step 4: Install the dependencies
RUN npm install

# Step 5: Copy the rest of the application into the container
COPY . .

# Step 6: Build the production version of the app
RUN npm run build

# Step 7: Use an Nginx image to serve the built app
FROM nginx:alpine

# Step 8: Copy the build output from the builder stage into Nginx's html folder
COPY --from=builder /app/dist /usr/share/nginx/html

# Step 9: Expose port 80
EXPOSE 80

# Step 10: Start Nginx to serve the app
CMD ["nginx", "-g", "daemon off;"]
