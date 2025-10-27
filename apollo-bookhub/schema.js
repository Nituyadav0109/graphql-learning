export const typeDefs = `#graphql
  type Book {
    id: ID!
    title: String!
    author: Author!
    price: Float!
  }

  type Author {
    id: ID!
    name: String!
    books: [Book!]
  }

  type Query {
    books: [Book!]
    book(id: ID!): Book
    authors: [Author!]
  }

  type Mutation {
    addBook(title: String!, authorId: ID!, price: Float!): Book
  }
`;
