--Precisa ter os mesmos nomes do schema
INSERT INTO usuarios (uuid, nome, email, dob) VALUES
('550e8400-e29b-41d4-a716-446655440001', 'João Silva', 'joao.silva@email.com', '1990-05-15'),
('550e8400-e29b-41d4-a716-446655440002', 'Maria Santos', 'maria.santos@email.com', '1985-08-22'),
('550e8400-e29b-41d4-a716-446655440003', 'Pedro Oliveira', 'pedro.oliveira@email.com', '1992-03-10'),
('550e8400-e29b-41d4-a716-446655440004', 'Ana Costa', 'ana.costa@email.com', '1988-11-30'),
('550e8400-e29b-41d4-a716-446655440005', 'Carlos Ferreira', 'carlos.ferreira@email.com', '1995-07-18'),
('550e8400-e29b-41d4-a716-446655440006', 'Juliana Almeida', 'juliana.almeida@email.com', '1991-02-25'),
('550e8400-e29b-41d4-a716-446655440007', 'Roberto Lima', 'roberto.lima@email.com', '1987-09-14'),
('550e8400-e29b-41d4-a716-446655440008', 'Fernanda Souza', 'fernanda.souza@email.com', '1993-12-05'),
('550e8400-e29b-41d4-a716-446655440009', 'Lucas Pereira', 'lucas.pereira@email.com', '1989-06-28'),
('550e8400-e29b-41d4-a716-446655440010', 'Patricia Rocha', 'patricia.rocha@email.com', '1994-04-17');

INSERT INTO postagens (uuid, titulo, corpo, data_criacao, usuario_id) VALUES
('650e8400-e29b-41d4-a717-446655440001', 'Minha primeira postagem', 'Conteúdo interessante sobre tecnologia', '2024-01-15', 1),
('650e8400-e29b-41d4-a717-446655440002', 'Reflexões do dia', 'Pensamentos sobre o desenvolvimento pessoal', '2024-02-20', 1),
('650e8400-e29b-41d4-a717-446655440003', 'Dicas de programação', 'Como melhorar seu código Java', '2024-01-10', 2),
('650e8400-e29b-41d4-a717-446655440004', 'Tutorial Spring Boot', 'Guia completo para iniciantes', '2024-03-05', 2),
('650e8400-e29b-41d4-a717-446655440005', 'Viagem inesquecível', 'Relato da minha viagem ao exterior', '2024-02-14', 3),
('650e8400-e29b-41d4-a717-446655440006', 'Receitas favoritas', 'Compartilhando receitas da família', '2024-01-25', 3),
('650e8400-e29b-41d4-a717-446655440007', 'Tendências 2024', 'O que esperar para este ano', '2024-01-05', 4),
('650e8400-e29b-41d4-a717-446655440008', 'Música e arte', 'Minha paixão pela música clássica', '2024-03-12', 4),
('650e8400-e29b-41d4-a717-446655440009', 'Exercícios físicos', 'Rotina de treinos que funcionou para mim', '2024-02-08', 5),
('650e8400-e29b-41d4-a717-446655440010', 'Alimentação saudável', 'Dicas para uma vida mais equilibrada', '2024-03-18', 5),
('650e8400-e29b-41d4-a717-446655440011', 'Livros recomendados', 'Minhas leituras favoritas do mês', '2024-01-20', 6),
('650e8400-e29b-41d4-a717-446655440012', 'Produtividade no trabalho', 'Técnicas que uso no dia a dia', '2024-02-28', 6),
('650e8400-e29b-41d4-a717-446655440013', 'Fotografia básica', 'Começando no mundo da fotografia', '2024-03-01', 7),
('650e8400-e29b-41d4-a717-446655440014', 'Natureza e meio ambiente', 'A importância da preservação', '2024-01-30', 7),
('650e8400-e29b-41d4-a717-446655440015', 'Carreira profissional', 'Como crescer na sua área', '2024-02-17', 8),
('650e8400-e29b-41d4-a717-446655440016', 'Hobbies criativos', 'Descobrindo novos passatempos', '2024-03-08', 8),
('650e8400-e29b-41d4-a717-446655440017', 'Tecnologia e inovação', 'As novidades que vêm por aí', '2024-01-12', 9),
('650e8400-e29b-41d4-a717-446655440018', 'Games favoritos', 'Análise dos jogos que mais gosto', '2024-02-22', 9),
('650e8400-e29b-41d4-a717-446655440019', 'Empreendedorismo', 'Dicas para começar seu negócio', '2024-03-15', 10),
('650e8400-e29b-41d4-a717-446655440020', 'Planejamento financeiro', 'Organizando suas finanças pessoais', '2024-02-10', 10);

-- amizades (usuario_a, usuario_b) referenciam ids de 'usuarios' inseridos acima
-- Inserir amizades buscando os ids pelos UUIDs para garantir integridade referencial
INSERT INTO amizade (usuario_a, usuario_b)
SELECT ua.id, ub.id FROM usuarios ua, usuarios ub
WHERE ua.uuid = '550e8400-e29b-41d4-a716-446655440001' AND ub.uuid = '550e8400-e29b-41d4-a716-446655440002'
AND NOT EXISTS (
	SELECT 1 FROM amizade a WHERE a.usuario_a = ua.id AND a.usuario_b = ub.id
);

INSERT INTO amizade (usuario_a, usuario_b)
SELECT ua.id, ub.id FROM usuarios ua, usuarios ub
WHERE ua.uuid = '550e8400-e29b-41d4-a716-446655440001' AND ub.uuid = '550e8400-e29b-41d4-a716-446655440003'
AND NOT EXISTS (
	SELECT 1 FROM amizade a WHERE a.usuario_a = ua.id AND a.usuario_b = ub.id
);