import { ApolloServer } from "@apollo/server";
import { startStandaloneServer } from "@apollo/server/standalone";
import { typeDefs } from "./schema.js";
import { books, authors } from "./data.js";

const resolvers = {
  Query: {
    books: () => books,
    book: (_, { id }) => books.find(b => b.id === id),
    authors: () => authors,
  },
  Mutation: {
    addBook: (_, { title, authorId, price }) => {
      const newBook = { id: String(books.length + 1), title, authorId, price };
      books.push(newBook);
      return newBook;
    },
  },
  Book: {
    author: (book) => authors.find(a => a.id === book.authorId),
  },
  Author: {
    books: (author) => books.filter(b => b.authorId === author.id),
  },
};

const server = new ApolloServer({ typeDefs, resolvers });
const { url } = await startStandaloneServer(server, { listen: { port: 4000 } });

console.log(`📚 Apollo BookHub running at ${url}`);
