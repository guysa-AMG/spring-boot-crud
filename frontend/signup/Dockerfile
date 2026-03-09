FROM node:22

WORKDIR frontend/

COPY . .

RUN npm i

RUN npm run build

CMD ["npm","run","start"]
