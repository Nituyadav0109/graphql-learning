import { CanyonServer } from "@canyon/server";
import { resolvers } from "./resolvers.js";
import schema from "./schema.graphql";

const server = new CanyonServer({ typeDefs: schema, resolvers });
server.listen({ port: 4001 }).then(({ url }) => {
  console.log(`🚀 Canyon BookHub running at ${url}`);
});
