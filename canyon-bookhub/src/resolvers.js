import { books, authors } from "../data.js";

export const resolvers = {
  Query: {
    books: () => books,
    book: (_, { id }) => books.find(b => b.id === id),
    authors: () => authors,
  },
  Book: {
    author: (book) => authors.find(a => a.id === book.authorId),
  },
  Author: {
    books: (author) => books.filter(b => b.authorId === author.id),
  },
};
