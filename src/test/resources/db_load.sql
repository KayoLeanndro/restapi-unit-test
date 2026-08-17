INSERT INTO usuario (id, nome)
VALUES
    ('a7581bb7-eddc-4fd5-8dad-6337378f8da0', 'Kayo'),
    ('f2ae0ac3-6e6a-4bc2-9160-7e109a4c8a11', 'Maria');


INSERT INTO mensagem (
    id,
    usuario_id,
    quantidade_gostei,
    conteudo,
    data_criacao,
    data_alteracao
)
VALUES
    (
        '16dbffa2-8419-4e62-88fe-e9a0515751fa',
        'a7581bb7-eddc-4fd5-8dad-6337378f8da0',
        5,
        'Primeira mensagem do Kayo',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    ),
    (
        'ca0e36d7-9f57-431b-88ee-bc383600ffd9',
        'a7581bb7-eddc-4fd5-8dad-6337378f8da0',
        2,
        'Segunda mensagem do Kayo',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    ),
    (
        '83763b7b-1da2-4057-b1f3-af9ec45268ff',
        'f2ae0ac3-6e6a-4bc2-9160-7e109a4c8a11',
        8,
        'Primeira mensagem da Maria',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    ),
    (
        'e1d1173b-8fd6-4569-8abc-0eb49f3fc70b',
        'f2ae0ac3-6e6a-4bc2-9160-7e109a4c8a11',
        3,
        'Segunda mensagem da Maria',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    );