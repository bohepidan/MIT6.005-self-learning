# MIT 6.005 SUMMARY
- **[Lecture website](https://ocw.mit.edu/courses/6-005-software-construction-spring-2016/pages/readings/)**

## Reading 3 : Testing
- Test-first programming. Write tests before you write code.
- Partitioning and boundaries for choosing test cases systematically.
- White box testing and statement coverage for filling out a test suite.
- Unit-testing each module, in isolation as much as possible.
- Automated regression testing to keep bugs from coming back.

## Reading 4 : Code Review
- Don’t Repeat Yourself (DRY)
- Comments where needed
- Fail fast
- Avoid magic numbers
- One purpose for each variable
- Use good names
- No global variables
- Return results, don’t print them
- Use whitespace for readability

## Reading 5 : Version Control
- *How Git works and how to use it*
> Everything you need to know about Git is on the [Pro Git book](https://git-scm.com/book/zh/v2).

## Readng 6 : Specifications
- *An appropriately weak specification gives freedom to the implementor, and an appropriately strong specification gives freedom to the client.*
- *Java exception statement*

## Reading 7 : Designing Specifications
- *Three dimensions for comparing specs: deterministic, declarative, strong*
- *Package and Access Controll*
- *An appropriately weak specification gives freedom to the implementor, and an appropriately strong specification gives freedom to the client.*

## Reading 8 : Avoiding Debugging
- *Use assert in code implementation*
- *Modualrity & Encapsulation*
- Avoid debugging
  - make bugs impossible with techniques like static typing, automatic dynamic checking, and immutable types and references
- Keep bugs confined
  - failing fast with assertions keeps a bug’s effects from spreading
  - incremental development and unit testing confine bugs to your recent code
  - scope minimization reduces the amount of the program you have to search