import { Person } from "./person";

export class Project {
    id: number | undefined;
    nome: string | undefined;
    dataInicio: string | undefined;
    dataPrevisaoFim: string | undefined;
    dataFim: string | undefined;
    descricao: string | undefined;
    gerente: Person | undefined;
    status: string | undefined;
    risco: string | undefined;
    orcamento: string | undefined;
    pessoas: Person[] | undefined;
}
