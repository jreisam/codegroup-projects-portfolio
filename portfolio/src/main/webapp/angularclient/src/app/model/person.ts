import { Project } from "./project";

export class Person {
    id: number | undefined;
    nome: string | undefined;
    dataNascimento: string | undefined;
    cpf: string | undefined;
    funcionario: boolean | undefined;
    cargo: string | undefined;
    projetos: Project[] | undefined;
}
